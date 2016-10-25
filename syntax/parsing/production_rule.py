class ProductionRule:
    def __init__(self, line):
        """
        :param line: str of the following form:
                     <nt> -> [sym] [sym] [sym] ...
                     Eg: non_terminal_1 ->
                     Eg: n -> T_3 T4 TERMINAL
        """
        symbols = line.split()
        self.lhs = symbols[0]
        assert(symbols[1] == '->')
        self.rhs = tuple(symbols[2:])

    def __str__(self):
        # Eg.
        # non_term ->
        # non_term -> term1 term2
        return self.lhs + ' ->' + ('' if len(self.rhs) == 0 else ' ' + ' '.join(self.rhs))

    def __eq__(self, other):
        try:
            return isinstance(other, self.__class__) and \
                   self.lhs == other.lhs and \
                   self.rhs == other.rhs
        except:
            return False

    def __hash__(self):
        return hash((self.lhs, self.rhs))
