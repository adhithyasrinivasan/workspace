'''
Created on 18-Dec-2017

@author: user
'''
#from pageobject_support import cacheable, callable_find_by as find_by
from selenium.webdriver.common.by import By

class MyClass(object):
    '''
    classdocs
    '''
    def __init__(self, driver):
        '''
        Constructor
        '''
        self._driver=driver
        
    def search(self):
        self.get("http://www.google.co.in")
        self.find_by(how=By.NAME, using='q').click()
        