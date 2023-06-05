const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getUncommunicableDeaths = (req, res, next) => {
    mysqlcons.uncommunicableDeaths()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getUncommunicableDeaths
};