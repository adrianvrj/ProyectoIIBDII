const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getFertilityRate = (req, res, next) => {
    mysqlcons.fertilityRate()
    .then((response)=>{
        //console.log("Hola", response)
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getFertilityRate
};