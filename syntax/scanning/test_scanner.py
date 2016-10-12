"""
If you have created your own instance of a Scanner and want to test it,
you can use the TestScanner provided here

To test:
    1. Inherit from TestScanner
    2. def setUp(self):
           # Your scanner initialization here
    3. Use test methods defined below
"""
import unittest

from syntax.scanning import CantTokenize


class TestScanner(unittest.TestCase):
    def compare_tokenized_input(self, input, correct_tokens):
        """
        Tokenize the input into a sequence of tokens.
        Compare the computed tokens to the correct_tokens.
        :param input: sequence of symbols
        :param correct_tokens: sequence of Tokens
        :raises: Exception if input is incorrectly tokenized
        """
        computed_tokens = self.scanner.tokenize(input)
        assert(len(computed_tokens) == len(correct_tokens))
        for correct_token, computed_token in zip(correct_tokens, computed_tokens):
            assert(correct_token.type == computed_token.type)
            assert(correct_token.lexeme == computed_token.lexeme)

    def assert_fails_tokenization(self, iterable):
        """
        Assert that iterable fails to be tokenized

        Otherwise, if iterable is tokenized, throw an Exception
        :param iterable: sequence of input
        :raises: Exception if tokenization did not fail
        """
        try:
            self.scanner.tokenize(iterable)
        except CantTokenize:
            return
        raise Exception('Should have failed to tokenize ' + iterable)


