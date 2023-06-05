const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getHomicidadesAvgCountrySex = (req, res, next) => {
    mysqlcons.homicidesAvgCountrySex()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getHomicidadesAvgCountrySex
};