const MySqlConsultor = require('../db_connection/mysql');
const mysqlcons = new MySqlConsultor();
const getLifeExpectancyBirthDecade = (req, res, next) => {
    mysqlcons.lifeExpectancyBirthDecade()
    .then((response)=>{
        res.status(201).json(response)
    })
    .catch(e=>console.log(e))

};

module.exports = {
    getLifeExpectancyBirthDecade
};