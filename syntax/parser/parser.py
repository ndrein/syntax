class CFG:
    def __init__(self, lines=None, cfg_file=None):
        if lines:
            self.rules = {ProductionRule(line) for line in lines}
        elif cfg_file:
            with open(cfg_file) as f:
                self.__init__(f.readlines())
        else:
            rules = set()


class ProductionRule:
    def __init__(self, line=None, lhs=None, rhs=None):
        if line:
            pass
        elif lhs and rhs:
            pass
        else:
            self.lhs = None
            self.rhs = None

    def __init__(self, lhs, rhs):
        """
        :param lhs: Token type
        :param rhs: sequence of Token types
        """
        self.lhs = lhs
        self.rhs = rhs


class Parser:
    # TODO: decide whether to use LL(1), LR(1), etc.  Take a parsing dfa as parameter
    def __init__(self, production_rules):
        """
        :param production_rules: set of ProductionRules
        """
        self.production_rules = production_rules

    def parse(self, tokens):
        """
        :param tokens: sequence of Token.{type, lexeme}
        :return: ParseTree
        """
        # TODO
