const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getInjuriesDeaths = (req, res, next) => {
    mysqlcons.injuriesDeaths()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getInjuriesDeaths
};