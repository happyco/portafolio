import os
import time
from selenium import webdriver


class Enviroment(object):

    def __init__(self):
        self.environment = None

    def set_environment(self, environment, url):

        if environment.lower() == 'firefox':
            driver = webdriver.Firefox()
            driver.get(url)
            self.environment = driver
        elif environment.lower() == 'chrome':
            driver = webdriver.Chrome(os.path.join(os.path.dirname(__file__), 'chromedriver.exe'))
            driver.get(url)
            self.environment = driver
        else:
            raise 'Environment not define'

    def close(self):
        self.environment.close()


_singletonEnviroment = Enviroment()
