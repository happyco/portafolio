from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from Enviroment import _singletonEnviroment


class Ologin (object):

    def emailtxt(self):
        return WebDriverWait(_singletonEnviroment.environment, 5).until(
            EC.presence_of_element_located((By.ID, "identifierId")))
        #return driver.find_element_by_id("Email")

    def nextbutton(self):
        return WebDriverWait(_singletonEnviroment.environment, 2).until(
            EC.presence_of_element_located((By.ID, "identifierNext")))
        #return driver.find_element_by_id("next")

    def pswdtxt(self):
        return WebDriverWait(_singletonEnviroment.environment, 2).until(
            EC.presence_of_element_located((By.NAME, "password")))
        #return driver.find_element_by_id("Passwd")

    def siginbutton(self):
        return WebDriverWait(_singletonEnviroment.environment, 2).until(
            EC.presence_of_element_located((By.ID, "passwordNext")))
        #return driver.find_element_by_id("signIn")