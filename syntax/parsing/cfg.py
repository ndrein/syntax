import json, string

from syntax.parsing import ProductionRule


class CFG:
    """
    Contains a set of ProductionRules

    Can be constructed using json, a CFG file, or dict
    """
    @staticmethod
    def multi_partition(lst, *predicates):
        """
        Partition lst into lists according to predicates

        If the ith predicate holds for a given element, that element will fall into bin i
        :param predicates: iterable of unary predicates
        :return: iterable of sets, each containing some of the elements from lst
        """
        # Create an empty set for each predicate
        lists = [list() for i in range(len(predicates))]
        for elem in lst:
            # If predicate i is true for this elem, add this elem to the ith set
            for index, predicate in enumerate(predicates):
                if predicate(elem):
                    lists[index].append(elem)

        return lists


    @staticmethod
    def is_terminal(word):
        """
        Determine if word is a terminal

        Terminals must begin with an uppercase letter and contain nothing
        but uppercase letters, digits, and the underscore
        :param word: string
        :return: True / False
        """
        terminal_symbols = set(string.ascii_uppercase + string.digits + '_')
        return word[0].isupper() and set(word) < terminal_symbols


    @staticmethod
    def is_non_terminal(word):
        """
        Determine if word is a non-terminal

        Non-terminals must begin with an lowercase letter and contain nothing
        but lowercase letters, digits, and the underscore
        :param word: string
        :return: True / False
        """
        non_terminal_symbols = set(string.ascii_lowercase + string.digits + '_')
        return word[0].islower() and set(word) < non_terminal_symbols

    @classmethod
    def from_cfg_file(cls, filename):
        """
        :param filename: path to cfg file
        :return: CFG
        """
        return cls.from_cfg_str(open(filename).read())

    @classmethod
    def from_cfg_str(cls, cfg_str):
        """
        :param cfg_str: raw str representing the CFG (with newlines)
        :return: CFG
        """
        symbols = cfg_str.split()

        # The start symbol is always the first symbol
        start_symbol = symbols[0]

        # All uppercase/lowercase words are terminals/non_terminals
        terminals, non_terminals = cls.multi_partition(symbols, cls.is_terminal, cls.is_non_terminal)

        return cls(dict({
            'terminals' : terminals,
            'non_terminals' : non_terminals,
            'start_symbol' : start_symbol,
            'rules' : cfg_str.splitlines()
        }))


    @classmethod
    def from_json_file(cls, filename):
        """
        :param filename: path to json file
        :return: CFG
        """
        return cls.from_json_str(open(filename).read())

    @classmethod
    def from_json_str(cls, json_str):
        """
        :param json_str: json in a string
        :return: CFG
        """
        return cls(dictionary=json.loads(json_str))

    def __init__(self, dictionary):
        """
        Construct a CFG given a dict as follows:

        terminals        -> list of strings
        non_terminals    -> list of strings
        start_symbol     -> string
        rules -> (possibly empty) list of strings in the following form:
        <nt> -> [sym] [sym] [sym] ...
        """
        # Make sure the dictionary contains the 4 components of a CFG
        assert(set(dictionary.keys()) == {'terminals', 'non_terminals', 'start_symbol', 'rules'})

        self.terminals = set(dictionary['terminals'])
        self.non_terminals = set(dictionary['non_terminals'])
        self.start_symbol = dictionary['start_symbol']

        self.rules = {ProductionRule(rule_str) for rule_str in dictionary['rules']}

