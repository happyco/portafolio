import unittest
from objects.Enviroment import _singletonEnviroment
import Tinbox, Tlogin

# This is an approach with unittest, testing each test case from the beginning, there is another approaches


class TestCase(unittest.TestCase):

    def setUp(self):
        _singletonEnviroment.set_environment('chrome', 'http://www.gmail.com')

    def test_login(self):
        self.assertTrue(Tlogin.login('testselenium1989asd', 'selenium'), 'Error found at login')

    def test_login_logout(self):
        self.assertTrue(Tlogin.login('testselenium1989asd', 'selenium'), 'Error found at login')
        self.assertTrue(Tinbox.logout(), 'Error found at logout')

    def tearDown(self):
        _singletonEnviroment.close()

if __name__ == '__main__':
    unittest.main()
