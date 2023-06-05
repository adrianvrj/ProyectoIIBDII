const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getFatalityBirthDecadeCountry = (req, res, next) => {
    mysqlcons.fatalityBirthDecadeCountry()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getFatalityBirthDecadeCountry   
};