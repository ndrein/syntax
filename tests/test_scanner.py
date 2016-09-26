# TODO: rewrite using compare_tokenized_input
import unittest
import string

# TODO: should be independent of lib
from lib.syntax.syntax.scanner import Scanner, Token, CantTokenize


class TestScanner(unittest.TestCase):
    def compare_tokenized_input(self, input, correct_tokens):
        """
        Tokenize the input into a sequence of tokens.
        Compare the computed tokens to the correc_tokens.
        :param input: sequence of symbols
        :param correct_tokens: sequence of Tokens
        :raises: Exception if input is incorrectly tokenized
        """
        computed_tokens = self.scanner.tokenize(input)
        assert(len(computed_tokens) == len(correct_tokens))
        for correct_token, computed_token in zip(correct_tokens, computed_tokens):
            assert(correct_token.type == computed_token.type)
            assert(correct_token.lexeme == computed_token.lexeme)

    def assert_fails_tokenization(self, string):
        try:
            self.scanner.tokenize(string)
        except CantTokenize:
            return
        raise Exception('Should have failed to tokenize ' + string)


class TestSimpleDFA(TestScanner):
    def setUp(self):
        alphabet = list('abc')
        states = list(range(5))
        start_state = 0
        accept_states = [1, 4]
        transitions = dict()

        transitions[0, 'a'] = 0
        transitions[0, 'b'] = 1
        transitions[0, 'c'] = 2
        transitions[2, 'b'] = 2
        transitions[2, 'a'] = 3
        transitions[3, 'b'] = 4

        state_map = dict.fromkeys(range(5))

        self.scanner = Scanner(Scanner.DFA(alphabet, states, start_state, accept_states, transitions), state_map)

    def test_simple(self):
        tokens = self.scanner.tokenize('b')
        assert(len(tokens) == 1)
        assert(tokens[0].lexeme == 'b')

    def test_single_failed_tokenize(self):
        self.assert_fails_tokenization('aaabc')

    def test_multiple_failed_tokenize(self):
        # b passes, cac fails
        self.assert_fails_tokenization('b' 'cac' 'cab')

    def test_tokenize(self):
        tokens = self.scanner.tokenize('aacbab' 'b' 'cab' '')
        assert(tokens[0].lexeme == 'aacbab')
        assert(tokens[1].lexeme == 'b')
        assert(tokens[2].lexeme == 'cab')

    def test_empty_input(self):
        tokens = self.scanner.tokenize('')
        assert(tokens == [])


class NumbersAndIDs(unittest.TestCase):
    def setUp(self):
        alphabet = list('0123456789') + list(string.ascii_lowercase)
        states = {'start', 'zero', 'non_zero_numeric', 'id'}
        start_state = 'start'
        accept_states = {'zero', 'non_zero_numeric', 'id'}
        transitions = dict()

        transitions['start', '0'] = 'zero'
        transitions = Scanner.DFA.build_multiple_transitions(transitions, 'start', '123456789', 'non_zero_numeric')
        transitions = Scanner.DFA.build_multiple_transitions(transitions, 'non_zero_numeric', '0123456789', 'non_zero_numeric')
        transitions = Scanner.DFA.build_multiple_transitions(transitions, 'start', string.ascii_lowercase, 'id')
        transitions = Scanner.DFA.build_multiple_transitions(transitions, 'id', list(string.ascii_lowercase) + list('0123456789'), 'id')

        state_map = dict({
            'zero': 'NUM',
            'non_zero_numeric': 'NUM',
            'id': 'ID'
        })

        self.scanner = Scanner(Scanner.DFA(alphabet, states, start_state, accept_states, transitions), state_map)

    def test_zero(self):
       tokens = self.scanner.tokenize('0')
       assert(len(tokens) == 1)
       assert(tokens[0].lexeme == '0')
       assert(tokens[0].type == 'NUM')

    def test_simple_num(self):
        tokens = self.scanner.tokenize('102304')
        assert(len(tokens) == 1)
        assert(tokens[0].lexeme == '102304')
        assert(tokens[0].type == 'NUM')

    def test_simple_whitespace(self):
        tokens = self.scanner.tokenize('102 304')
        assert(len(tokens) == 2)
        assert(tokens[0].lexeme == '102')
        assert(tokens[0].type == 'NUM')
        assert(tokens[1].lexeme == '304')
        assert(tokens[1].type == 'NUM')

    def test_all_whitespace(self):
        assert(len(self.scanner.tokenize('          ')) == 0)

    def test_leading_and_trailing_whitespace(self):
        tokens = self.scanner.tokenize(' a123     ')
        assert(len(tokens) == 1)
        assert(tokens[0].lexeme == 'a123')

    def test_ids(self):
        tokens = self.scanner.tokenize('      0' '120\n' '90' 'a999\t' '9990   \n\t' '0')
        assert(len(tokens) == 6)

        assert(tokens[0].lexeme == '0')
        assert(tokens[0].type == 'NUM')

        assert(tokens[1].lexeme == '120')
        assert(tokens[1].type == 'NUM')

        assert(tokens[2].lexeme == '90')

        assert(tokens[3].lexeme == 'a999')
        assert(tokens[3].type == 'ID')

        assert(tokens[4].lexeme == '9990')
        assert(tokens[4].type == 'NUM')

        assert(tokens[5].lexeme == '0')
        assert(tokens[5].type == 'NUM')


class SpaceQuotes(TestScanner):
    def setUp(self):
        alphabet = ['"', ' ', 'a']
        states = ['START', 'a', 'quote', 'done_quote']
        start_state = 'START'
        accept_states = ['START', 'a', 'done_quote']

        transitions = dict()

        transitions['START', 'a'] = 'a'
        transitions['START', '"'] = 'quote'

        transitions['a', 'a'] = 'a'

        transitions['quote', 'a'] = 'quote'
        transitions['quote', ' '] = 'quote'
        transitions['quote', '"'] = 'done_quote'

        transitions['no_quote', 'a'] = 'a'
        transitions['no_quote', '"'] = 'quote'

        state_map = dict({
            'a': 'A',
            'done_quote': 'QUOTE'
        })

        self.scanner = Scanner(Scanner.DFA(alphabet, states, start_state, accept_states, transitions), state_map, token_delimiters=[' '])

    def test_empty(self):
        self.compare_tokenized_input([], [])

    def test_a(self):
        self.compare_tokenized_input(['a', 'a', 'a'], [Token('A', ['a', 'a', 'a'])])

    def test_space(self):
        self.compare_tokenized_input(' ', [])

    def test_quote(self):
        self.compare_tokenized_input('""', [Token('QUOTE', '""')])

    def test_space_in_quote(self):
        self.compare_tokenized_input(['"', ' ', '"'], [Token('QUOTE', ['"', ' ', '"'])])

    def test_space_as(self):
        self.compare_tokenized_input(['a', 'a', ' ', 'a', ' '], [Token('A', ['a', 'a']),
                                                                 Token('A', ['a'])])

    def test_space_in_and_out_of_quote(self):
        self.compare_tokenized_input(' " a " a ', [Token('QUOTE', '" a "'),
                                                   Token('A', 'a')])

    def test_bad_quote(self):
        self.assert_fails_tokenization(['"', ' '])
