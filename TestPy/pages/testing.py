'''
Created on 05-Apr-2017

@author: adhithya
'''
import unittest
from driver.Base import *


class PythonOrgSearch(unittest.TestCase):
    def setUp(self):
        self.driver = setup_driver()
    def tearDown(self):
        self.driver.close()
    if __name__ == "__main__":
        unittest.TestCase()

