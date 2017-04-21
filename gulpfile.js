var gulp = require("gulp"),//http://gulpjs.com/
    util = require("gulp-util"),//https://github.com/gulpjs/gulp-util
    sass = require("gulp-sass"),//https://www.npmjs.org/package/gulp-sass
    babel = require("gulp-babel"),
    autoprefixer = require('gulp-autoprefixer'),//https://www.npmjs.org/package/gulp-autoprefixer
    minifycss = require('gulp-minify-css'),//https://www.npmjs.org/package/gulp-minify-css
    rename = require('gulp-rename'),//https://www.npmjs.org/package/gulp-rename
    log = util.log;


var cssTarget = "src/main/webapp/resources/css/";

gulp.task("default", ["sass", "resource-copying", "babel-task"]);

gulp.task("sass", function () {
    log("Generating CSS files " + (new Date()).toString());
    gulp.src("src/main/resources/scss/all.scss")
        .pipe(sass({style: 'expanded'}))
        .pipe(autoprefixer("last 3 version", "safari 5", "ie 9"))
        .pipe(gulp.dest(cssTarget))
        .pipe(rename({suffix: '.min'}))
        .pipe(minifycss())
        .pipe(gulp.dest(cssTarget));
});

gulp.task("watch", function () {
    log("Watching scss files for modifications");
    gulp.watch(sassFiles, ["sass"]);
});

gulp.task("resource-copying", function () {
    log("Copy material icons " + (new Date()).toString());
    gulp.src("node_modules/material-design-icons/action/1x_web/ic_autorenew_black_48dp.png")
        .pipe(gulp.dest("src/main/webapp/resources/images/"));
});

gulp.task("babel-task", function () {
    return gulp.src('src/main/resources/js/*.js')
        .pipe(babel({
            presets: ['es2015']
        }))
        .pipe(gulp.dest('src/main/webapp/resources/js/'));
});
