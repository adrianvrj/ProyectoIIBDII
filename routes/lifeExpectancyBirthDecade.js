const express = require('express');
const lifeExpectancyBirthDecade = require('../controllers/lifeExpectancyBirthDecade');
const router = express.Router();

router.get('/', lifeExpectancyBirthDecade.getLifeExpectancyBirthDecade);


module.exports = router