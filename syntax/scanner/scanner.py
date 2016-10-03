# This module takes a DFA as input, and can be used to tokenize strings

import collections
import string

from lib.syntax.syntax.dfa import DFA, CantTraverse


Token = collections.namedtuple('Token', ['type', 'lexeme'])

class CantTokenize(Exception):
    def __init__(self, message, reason=''):
        self.message = message
        self.reason = reason


class Scanner:
    @staticmethod
    def strip_leading_elems(elems, input):
        """
        Remove the leading instances of elems in input, and return the result

        :param input: list
        :return: modified input
        """
        for index, elem in enumerate(input):
            if elem not in elems:
                return input[index:]

        return input[len(input):]


    DFA = DFA


    def __init__(self, dfa, state_map, token_delimiters=string.whitespace):
        """
        :param dfa: constructed using the Scanner.DFA class
        :param state_map: dict: state -> token type
                          (eg. if we end up in this state, what kind of token did we munch)
                          (eg. "var" state -> ID)
        :param token_delimiters: set of symbols that separate tokens
                                 defaults to whitespace
                                 token_delimieters are never part of a Token
        """
        self.dfa = dfa
        self.state_map = state_map
        self.token_delimiters = token_delimiters

    def strip_leading_delimiters(self, input):
        """
        Remove all leading instances of self.token_delimiters

        :param input: iterable of input
        :return: modified input
        """
        return input.lstrip(self.token_delimiters)

    def tokenize(self, input):
        """
        Take a sequence of input and return an array of Tokens

        :param input: iterable of symbols
        :return: iterable of Token.{type, lexeme}
        :raises: CantTokenize
        """
        tokens = []

        remaining = self.strip_leading_elems(self.token_delimiters, input)

        while len(remaining) > 0:
            try:
                consumed, remaining, final_state = self.dfa.traverse(remaining)
            except CantTraverse:
                raise CantTokenize('Can\'t tokenize the remaining input:\n' + str(remaining))

            tokens.append(Token(self.state_map[final_state], consumed))
            remaining = self.strip_leading_elems(self.token_delimiters, remaining)

        return tokens
