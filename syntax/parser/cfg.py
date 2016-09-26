import json

class CFG:
    """
    Contains a set of ProductionRules

    Can be constructed using json, a CFG file, or dict
    """
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
        terminals = {sym for sym in cfg_str.split() if sym.isupper()}
        non_terminals = {sym for sym in cfg_str.split() if sym.islower()()}

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
        production_rules -> (possibly empty) list of strings in the following form:
        <nt> -> [sym] [sym] [sym] ...
        """
        for attr in {'terminals', 'non_terminals', 'start_symbol'}:
            setattr(self, attr, dictionary[attr])

        self.rules = {ProductionRule(rule_str) for rule_str in dictionary['production_rules']}


class ProductionRule:
    # The divider between the left side and the right side, not including whitespace
    LHS_TO_RHS_DELIMITER = '->'

    def __init__(self, line):
        symbols = line.split()
        self.lhs = symbols[0]
        self.rhs = symbols[2:].split()


