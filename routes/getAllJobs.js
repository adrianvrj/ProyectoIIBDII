const express = require('express');
// const checkAuth = require('../Middleware/checkAuth.middleware');
const getAllJobs = require('../controllers/getAllJobs');
const router = express.Router();

router.get('/', getAllJobs.getAllJobs);


module.exports = router