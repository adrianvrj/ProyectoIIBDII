const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getHomicidesMinMaxRegionDecada = (req, res, next) => {
    mysqlcons.homicidesMinMaxRegionSexoDecada()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getHomicidesMinMaxRegionDecada
};