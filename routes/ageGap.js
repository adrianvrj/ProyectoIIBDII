const express = require('express');
const ageGapController = require('../controllers/ageGap');
const router = express.Router();

router.get('/', ageGapController.getAgeGap);


module.exports = router