'''
Created on 05-Apr-2017

@author: user
'''
from setuptools import setup

setup(name='TestPy',
      version='0.1',
      description='Selenium project',
      author='Adhithya Srinivasan',
      author_email='adhithyasrinivasan@gmail.driver',
      license='MIT',
      packages=['Test'],
      install_requires=[
          'selenium',
      ],
      zip_safe=False)