const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getHomicidadesAvgCountry = (req, res, next) => {
    mysqlcons.homicidesAvgCountry()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getHomicidadesAvgCountry
};