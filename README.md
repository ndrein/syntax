# syntax
Python implementation of scanning and parsing.  Given a scanner and a context-free grammar, generate a parse tree.


## Installation

See `setup.py`
```bash
pip install -e .
```


## Example
TODO


## Usage
```python
from syntax.dfa import DFA
from syntax.scanning import Scanner
```


## Test

Note: `--exe` must be used since Windows files are recognized by the WSL as executable.

```bash
nosetests --exe     # In root directory
```


Obtain `nosetests` via `pip`:
```bash
pip install nose
```
