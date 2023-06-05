const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getFatalityBirthDecadeCountryQuintil = (req, res, next) => {
    mysqlcons.fatalityBirthDecadeCountryQuintil()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getFatalityBirthDecadeCountryQuintil
};