const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getHomicidesMinMaxRegion = (req, res, next) => {
    mysqlcons.homicidesMinMaxRegion()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getHomicidesMinMaxRegion
};