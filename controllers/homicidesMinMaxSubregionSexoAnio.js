const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getHomicidesMinMaxSubregionSexoAnio = (req, res, next) => {
    mysqlcons.homicidesMinMaxSubregionSexoAnio()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getHomicidesMinMaxSubregionSexoAnio
};