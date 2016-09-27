import unittest

# TODO: should be independent of lib
from lib.syntax.syntax.parser.cfg import CFG


class SimpleCFG(unittest.TestCase):
    def setUp(self):
        cfg_dict = dict({
            'terminals': ['A'],
            'non_terminals': ['a'],
            'start_symbol': 'a',
            'production_rules': ['A -> a']
        })

        self.cfg = CFG(cfg_dict)

    def test_constructor_worked(self):
        pass
    # TODO: finish testing CFG
