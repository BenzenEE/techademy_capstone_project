import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By

@pytest.fixture
def driver():
    driver = webdriver.Chrome()
    driver.get("http://the-internet.herokuapp.com/")
    driver.maximize_window()
    yield driver
    driver.quit()

def isCheckBoxSelected(driver, xpath: str) -> bool:
    checkbox = driver.find_element(By.XPATH, xpath)
    return checkbox.is_selected()

def test_verify_title(driver):
    assert driver.title == "The Internet", "Page title doesn't match!"

def test_checkboxes(driver):
    driver.find_element(By.LINK_TEXT, "Checkboxes").click()

    checkbox_1 = isCheckBoxSelected(driver, "//*[@id='checkboxes']/input[1]")
    checkbox_2 = isCheckBoxSelected(driver, "//*[@id='checkboxes']/input[2]")

    assert not checkbox_1, "Checkbox 1 should not be selected!"
    assert checkbox_2, "Checkbox 2 should be selected!"

def test_file_upload(driver):
    driver.find_element(By.LINK_TEXT, "File Upload").click()

    file_input = driver.find_element(By.ID, "file-upload")
    file_input.send_keys(r"C:\Users\SAYAN DAS\Downloads\capstone_project.pdf")

    driver.find_element(By.ID, "file-submit").click()

