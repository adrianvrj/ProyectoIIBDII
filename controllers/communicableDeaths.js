const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getCommunicableDeaths = (req, res, next) => {
    mysqlcons.communicableDeaths()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getCommunicableDeaths
};