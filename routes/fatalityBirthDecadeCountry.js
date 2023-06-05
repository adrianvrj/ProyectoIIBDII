const express = require('express');
// const checkAuth = require('../Middleware/checkAuth.middleware');
const fatalityBirthDecadeCountry = require('../controllers/fatalityBirthDecadeCountry');
const router = express.Router();

router.get('/', fatalityBirthDecadeCountry.getFatalityBirthDecadeCountry);


module.exports = router