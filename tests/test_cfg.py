import unittest, os

# TODO: should be independent of lib
from lib.syntax.syntax.parser.cfg import CFG


RESOURCE_PATH = os.path.join(os.path.dirname(os.path.abspath(__file__)),
                             'resources')

class CFGFileTester(unittest.TestCase):
    def setUp(self):
        pass
    # TODO

class SimpleCFG(unittest.TestCase):
    def setUp(self):
        cfg_dict = dict({
            'terminals': ['A'],
            'non_terminals': ['a'],
            'start_symbol': 'a',
            'rules': ['A -> a']
        })

        self.cfg = CFG(cfg_dict)

    def test_constructor_worked(self):
        pass

    def test_simple_terminals(self):
        assert(set(self.cfg.terminals) == {'A'})

    def test_simple_non_terminals(self):
        assert(set(self.cfg.non_terminals) == {'a'})

    def test_simple_start_symbol(self):
        assert(self.cfg.start_symbol == 'a')

    def test_simple_rules(self):
        assert(len(self.cfg.rules) == 1)


class SimpleCFGFile(unittest.TestCase):
    def setUp(self):
        self.cfg = CFG.from_cfg_file(os.path.join(RESOURCE_PATH, 'simple_cfg_file.cfg'))

    def test_cfg_file_constructor_worked(self):
        pass

    def test_terminals(self):
        assert(set(self.cfg.terminals) == {'TERMINAL'})

    def test_non_terminals(self):
        assert(set(self.cfg.non_terminals) == {'start', 'n'})

    def test_start_symbol(self):
        assert(self.cfg.start_symbol == 'start')

    def test_rules(self):
        assert(len(self.cfg.rules) == 2)

