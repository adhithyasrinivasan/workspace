'''
Created on 12-Dec-2017

@author: user
'''
from selenium import webdriver

driver=None
def setup_driver():
    driver = webdriver.Firefox()
    driver.maximize_window()
    driver.set_page_load_timeout(15)
    return driver
