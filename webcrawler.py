import glob
import os
import time
import zipfile
import requests
from bs4 import BeautifulSoup
import pandas as pd
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.options import Options
chrome_options = Options()
chrome_options.add_argument('--headless')
driver = webdriver.Chrome(options=chrome_options)

def getHomicideCount():
    url = 'http://data.un.org/DocumentData.aspx?id=443'
    response = requests.get(url)
    html = response.content
    soup = BeautifulSoup(html, 'html.parser')
    table = soup.find('table', {'class': 'xl634848'})
    df = pd.read_html(str(table))[0]
    df.to_csv('data/homicidecount.csv', index=False)
    
def getHomicideSex():
    url = 'http://data.un.org/DocumentData.aspx?id=444'
    response = requests.get(url)
    html = response.content
    soup = BeautifulSoup(html, 'html.parser')
    table = soup.find('table', {'class': 'xl6313055'})
    df = pd.read_html(str(table))[0]
    df.to_csv('data/homicidesex.csv', index=False)
    
def getTotalMortalityRate():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHS2_3070_all'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "totalmortality"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)

def getCancerMortalityRate():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHS2_3070_cancer'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "cancerrate"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)

def getCardioVascularRate():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHS2_3070_cdd'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "cddrate"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)

def communicableDeaths():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHS2_513'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "communicableDeaths"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)
        
def noncommunicableDeaths():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHS2_163'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "noncommunicableDeaths"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)
        
def injuriesDeaths():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHS2_162'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "injuriesDeaths"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)
        
def mediaEdad():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHS9_88'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "mediaedad"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)
        
def totalPopulations():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHS9_86'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "totalpopulations"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)
        
def adolescentFertitlityRate1000():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aasfr1'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "adolescentfertitlityrate1000"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)
        
def totalFertilityRate():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3atfr'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "totalfertilityrate"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)

def birthExpentacy():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHOSIS_000001'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "birthexpentacy"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)
        
def domesticTourism():
    url = 'http://data.un.org/DocumentData.aspx?id=477'
    response = requests.get(url)
    html = response.content
    soup = BeautifulSoup(html, 'html.parser')
    table = soup.find('table', {'class': 'xl671800'})
    df = pd.read_html(str(table))[0]
    df.to_csv('data/domestictourism.csv', index=False)
 
def employmentTourism():
    url = 'http://data.un.org/DocumentData.aspx?id=459'
    response = requests.get(url)
    html = response.content
    soup = BeautifulSoup(html, 'html.parser')
    table = soup.find('table', {'cellpadding': '0'})
    df = pd.read_html(str(table))[0]
    df.to_csv('data/employmenttourism.csv', index=False)
    
def inboundTourism():
    url = 'http://data.un.org/DocumentData.aspx?id=481'
    response = requests.get(url)
    html = response.content
    soup = BeautifulSoup(html, 'html.parser')
    table = soup.find('table', {'class': 'xl7031357'})
    df = pd.read_html(str(table))[0]
    df.to_csv('data/inboundtourism.csv', index=False)          

def outboundTourism():
    url = 'http://data.un.org/DocumentData.aspx?id=458'
    response = requests.get(url)
    html = response.content
    soup = BeautifulSoup(html, 'html.parser')
    table = soup.find('table', {'class': 'xl692773'})
    df = pd.read_html(str(table))[0]
    df.to_csv('data/outboundtourism.csv', index=False)
    
def tourismIndustries():
    url = 'http://data.un.org/DocumentData.aspx?id=482'
    response = requests.get(url)
    html = response.content
    soup = BeautifulSoup(html, 'html.parser')
    table = soup.find('table', {'cellpadding': '0'})
    df = pd.read_html(str(table))[0]
    df.to_csv('data/tourismindustries.csv', index=False)

def infantMortalityRate():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aimr'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "infantmortalityrate"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)

def lifeExpectancyAtBirth():
    url = 'http://data.un.org/Data.aspx?d=WHO&f=MEASURE_CODE%3aWHOSIS_000001'
    driver.get(url)
    enlace = driver.find_element(By.LINK_TEXT, 'Download')
    enlace.click()
    time.sleep(2)
    enlace = driver.find_element(By.ID, 'downloadCommaLink')
    enlace.click()
    time.sleep(10)
    download_folder = "/Users/adrianvargas/Documents/I Semestre 2023/BDII/ProyectoIIBDII"
    list_of_files = glob.glob(download_folder + '/*.zip')
    latest_file = max(list_of_files, key=os.path.getctime)
    unzip_folder = "./data/oms"
    unzip_file = "lifeexpectancyatbirth"
    with zipfile.ZipFile(latest_file, 'r') as zip_ref:
        zip_ref.extractall(unzip_folder + unzip_file)

def main():
    getHomicideCount()
    getHomicideSex()
    getTotalMortalityRate()
    time.sleep(10)
    getCancerMortalityRate()
    time.sleep(10)
    getCardioVascularRate()
    time.sleep(10)
    communicableDeaths()
    time.sleep(10)
    noncommunicableDeaths()
    time.sleep(10)
    injuriesDeaths()
    time.sleep(10)
    mediaEdad()
    time.sleep(10)
    totalPopulations()
    time.sleep(10)
    adolescentFertitlityRate1000()
    time.sleep(10)
    totalFertilityRate()
    time.sleep(10)
    birthExpentacy()
    domesticTourism()
    employmentTourism()
    inboundTourism()
    outboundTourism()
    tourismIndustries()
    infantMortalityRate()
    time.sleep(10)

getHomicideSex()