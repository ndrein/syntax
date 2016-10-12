from distutils.core import setup


setup(name='syntax',
      version='0.0.0',
      url='https://github.com/ndrein/effloresce',
      author='Noah Reinhardt',
      packages=['dfa', 'scanning', 'parsing'],
      package_dir={'': 'syntax'})
