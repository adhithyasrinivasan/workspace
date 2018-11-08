'''
Created on 05-Apr-2017

@author: adhithya
'''
import unittest
from driver.Base import *


class PythonOrgSearch(unittest.TestCase):
    def setUp(self):
        #driverlocal=setup_driver()
        self.driver = setup_driver()
    def test_search_in_python_org(self):
        self.driver.get("http://www.google.co.in")
    def tearDown(self):
        self.driver.close()
    if __name__ == "__main__":
        unittest.TestCase()

