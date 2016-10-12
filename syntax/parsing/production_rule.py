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
        self.rhs = tuple(symbols[2:])

    def __str__(self):
        return self.lhs + ' ' + self.DELIMITER + [' ' + r_token for r_token in self.rhs]

    def __eq__(self, other):
        try:
            return isinstance(other, self.__class__) and \
                   self.lhs == other.lhs and \
                   self.rhs == other.rhs
        except:
            return False

    def __hash__(self):
        return hash((self.lhs, self.rhs))
