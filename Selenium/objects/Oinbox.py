from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from Enviroment import _singletonEnviroment


class Oinbox (object):

    def inbox(self):
        return WebDriverWait(_singletonEnviroment.environment, 10).until(
            EC.presence_of_element_located((By.CLASS_NAME, "UI")))

    def account_info(self):
        return _singletonEnviroment.environment.find_element_by_xpath(
            '//*[@id="gb"]/div[1]/div[1]/div[2]/div[4]/div[1]/a')

    def logout(self):
        return WebDriverWait(_singletonEnviroment.environment, 5).until(
            EC.presence_of_element_located((By.XPATH, "//*[@id='gb_71']")))
