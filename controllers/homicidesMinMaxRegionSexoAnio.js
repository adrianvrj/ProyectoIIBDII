const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getHomicidesMinMaxRegionAnio = (req, res, next) => {
    mysqlcons.homicidesMinMaxRegionSexoAnio()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getHomicidesMinMaxRegionAnio
};