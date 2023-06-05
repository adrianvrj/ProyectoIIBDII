const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getHomicidesMinMaxSubregionSexoDecada = (req, res, next) => {
    mysqlcons.homicidesMinMaxSubregionSexoDecada()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getHomicidesMinMaxSubregionSexoDecada
};