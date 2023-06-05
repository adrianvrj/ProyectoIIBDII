const mysql = require('mysql2');

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'password',
  database: 'chatInformation'
});

connection.connect((err) => {
  if (err) {
    console.error('Error connecting to MySQL database: ', err);
  } else {
    console.log('Connected to MySQL database');
  }
});

class MysqlConsultor {
    constructor() { }
   async getAllJobs(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT table_name FROM information_schema.tables WHERE table_schema = "chatInformation";', 
      function(error, results, fields){
        resolve(results);
      })
    });
   }
   // FERTILITY RATE COUNTRY DECADE
   async fertilityRate(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM fertitlity_rate_country_decade;', 
      function(error, results, fields){
        resolve(results);
      })
    });
   }
   // DECADE POBLATION
   async decadePoblation(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM decade_poblation;', 
      function(error, results, fields){
        resolve(results);
      })
    });
   }
   // FATALITY BIRTH DECADE COUNTRY
   async fatalityBirthDecadeCountry(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM fatality_birth_decade_country;', 
      function(error, results, fields){
        resolve(results);
      })
    });
   }
   // FERTILITY DECADE COUNTRY
   async fertilityDecadeCountry(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM fertility_decade_country;', 
      function(error, results, fields){
        resolve(results);
      })
    });
   }
  // HOMICIDES AVERAGE COUNTRY
  async homicidesAvgCountry(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM homcides_avg_country;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // HOMICIDES AVERAGE COUNTRY SEX
  async homicidesAvgCountrySex(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM homicides_avg_country_sex;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // LIFE EXPECTANCY BIRTH DECADE
  async lifeExpectancyBirthDecade(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM life_expectancy_birth_decade;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // COMMUNICABLE DEATHS
  async communicableDeaths(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM communicable_deaths;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // HOMICIDES MIN MAX REGION
  async homicidesMinMaxRegion(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM homicides_min_max_regiom;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // HOMICIDES MIN MAX REGION AÑO
  async homicidesMinMaxRegionSexoAnio(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM homicides_min_max_region_sexo_anio;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // HOMICIDES MIN MAX REGION DECADA
  async homicidesMinMaxRegionSexoDecada(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM homicides_min_max_region_sexo_decada;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // HOMICIDES MIN MAX SUBREGION
  async homicidesMinMaxSubregion(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM homicides_min_max_subregion;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // HOMICIDES MIN MAX SUBREGION AÑO
  async homicidesMinMaxSubregionSexoAnio(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM homicides_min_max_subregion_sexo_anio;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // HOMICIDES MIN MAX SUBREGION DECADA
  async homicidesMinMaxSubregionSexoDecada(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM homicides_min_max_subregion_sexo_decada;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // INJURIES DEATHS
  async injuriesDeaths(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM injuries_deaths;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // UNCOMMUNICABLE DEATHS
  async uncommunicableDeaths(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM uncommunicable_deaths;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // AGE GAP
  async ageGap(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM age_gap;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // FATALITY BIRTH DECADE COUNTRY QUINTIL
  async fatalityBirthDecadeCountryQuintil(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM fatality_birth_decade_country_quintil;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }
  // FERTILITY BIRTH DECADE COUNTRY QUINTIL
  async fertilityRateDecadeCountryQuintil(){
    return new Promise (function(resolve, reject){
      connection.query('SELECT * FROM fertility_rate_decade_country_quintil;', 
      function(error, results, fields){
        resolve(results);
      })
    });
  }

}

module.exports = MysqlConsultor;