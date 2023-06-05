const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getFertilityRateDecadeCountryQuintil = (req, res, next) => {
    mysqlcons.fertilityRateDecadeCountryQuintil()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getFertilityRateDecadeCountryQuintil
};