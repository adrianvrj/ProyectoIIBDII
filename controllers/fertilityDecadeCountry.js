const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getFertilityDecadeCountry = (req, res, next) => {
    mysqlcons.fertilityDecadeCountry()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getFertilityDecadeCountry
};