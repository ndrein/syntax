import json, string


class CFG:
    """
    Contains a set of ProductionRules

    Can be constructed using json, a CFG file, or dict
    """
    @staticmethod
    def multi_partition(lst, *predicates):
        """
        Partition lst into bins according to predicates

        If the ith predicate holds for a given element, that element will fall into bin i
        :param predicates: iterable of unary predicates
        :return: iterable of sets, each containing some of the elements from lst
        """
        # Create an empty set for each predicate
        bins = [set() for i in range(len(predicates))]
        for elem in lst:
            # If predicate i is true for this elem, add this elem to the ith set
            for index, predicate in enumerate(predicates):
                if predicate(elem):
                    bins[index].add(elem)

        return bins


    @staticmethod
    def is_terminal(word):
        terminal_symbols = set(string.ascii_uppercase + string.digits + '_')
        return word[0].isupper() and set(word) < terminal_symbols


    @staticmethod
    def is_non_terminal(word):
        non_terminal_symbols = set(string.ascii_lowercase + string.digits + '_')
        return word[0].islower() and set(word) < non_terminal_symbols

    @classmethod
    def from_cfg_file(cls, filename):
        """
        :param filename: path to cfg file
        :return: CFG
        """
        return cls.from_cfg_str(open(filename, 'r').read())

    @classmethod
    def from_cfg_str(cls, cfg_str):
        """
        :param cfg_str: raw str representing the CFG (with \n's)
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
        return cls.from_cfg_file(open(filename).read())

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
        assert(set(dictionary.keys()) == {'terminals', 'non_terminals', 'start_symbol', 'rules'})

        for attr in {'terminals', 'non_terminals', 'start_symbol'}:
            setattr(self, attr, dictionary[attr])

        self.rules = {ProductionRule(rule_str) for rule_str in dictionary['rules']}


class ProductionRule:
    # The divider between the left side and the right side, not including whitespace
    DELIMITER = '->'

    def __init__(self, line):
        """
        :param line: str of the following form:
                     <nt> DELIMITER [sym] [sym] [sym] ...
                     Eg: non_terminal_1 ->
                     Eg: n -> T_3 T4 TERMINAL
        """
        symbols = line.split()
        self.lhs = symbols[0]
        assert(symbols[1] == self.DELIMITER)
        self.rhs = symbols[2:]
