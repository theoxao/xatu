var gulp = require('gulp');
// var less = require('gulp-less');
var sass = require('gulp-sass');
var browserSync = require('browser-sync').create();
var header = require('gulp-header');
var cleanCSS = require('gulp-clean-css');
var rename = require("gulp-rename");
var uglify = require('gulp-uglify');
var pkg = require('./package.json');
var babel = require('gulp-babel');

var dist = '/deploy/static_assets';
var vendor = dist + 'vendor/';

// Set the banner content
var banner = ['/*!\n',
    ' * Start Bootstrap - <%= pkg.title %> v<%= pkg.version %> (<%= pkg.homepage %>)\n',
    ' * Copyright 2013-' + (new Date()).getFullYear(), ' <%= pkg.author %>\n',
    ' * Licensed under <%= pkg.license.type %> (<%= pkg.license.url %>)\n',
    ' */\n',
    ''
].join('');
//
// // Compile LESS files from /less into /css
// gulp.task('less', function() {
//     return gulp.src('less/**/*.less')
//         .pipe(less())
//         .pipe(header(banner, { pkg: pkg }))
//         .pipe(gulp.dest(dist + 'css'))
//         .pipe(browserSync.reload({
//             stream: true
//         }))
// });

// Compile SCSS files from /less into /css
gulp.task('sass', function () {
    return gulp.src('scss/**/*.scss')
        .pipe(sass())
        .pipe(header(banner, {pkg: pkg}))
        .pipe(gulp.dest(dist + 'css'))
        .pipe(browserSync.reload({
            stream: true
        }))
});

// Minify compiled CSS
gulp.task('minify-css', ['sass'], function () {
    return gulp.src([dist + '/css/**/*.css', '!' + dist + '/css/**/*.min.css'])
        .pipe(cleanCSS({compatibility: 'ie8'}))
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest(dist + 'css'))
        .pipe(browserSync.reload({
            stream: true
        }))
});

// Copy JS to dist
gulp.task('js', function () {
    return gulp.src(['js/**/*.js'])
        .pipe(babel({
            presets: ['es2015']
        }))
        .pipe(header(banner, {pkg: pkg}))
        .pipe(gulp.dest(dist + 'js'))
        .pipe(browserSync.reload({
            stream: true
        }))
});

// Minify JS
gulp.task('minify-js', ['js'], function () {
    return gulp.src('js/**/*.js')
        .pipe(babel({
            presets: ['es2015']
        }))
        .pipe(uglify())
        .pipe(header(banner, {pkg: pkg}))
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest(dist + 'js'))
        .pipe(browserSync.reload({
            stream: true
        }))
});

// Copy vendor libraries from /bower_components into /vendor
gulp.task('copy', function () {
    gulp.src(['images/**/*']).pipe(gulp.dest(dist + 'images'));

    gulp.src(['bower_components/bootstrap/dist/**/*', '!**/npm.js', '!**/bootstrap-theme.*', '!**/*.map'])
        .pipe(gulp.dest(vendor + 'bootstrap'));

    // gulp.src(['bower_components/tether/dist/**/*'])
    //     .pipe(gulp.dest(vendor + 'tether'));

    gulp.src(['bower_components/bootstrap-social/*.css', 'bower_components/bootstrap-social/*.less', 'bower_components/bootstrap-social/*.scss'])
        .pipe(gulp.dest(vendor + 'bootstrap-social'));

    gulp.src(['bower_components/datatables/media/**/*'])
        .pipe(gulp.dest(vendor + 'datatables'));

    gulp.src(['bower_components/datatables-plugins/integration/bootstrap/3/*'])
        .pipe(gulp.dest(vendor + 'datatables-plugins'));

    gulp.src(['bower_components/datatables-responsive/css/*', 'bower_components/datatables-responsive/js/*'])
        .pipe(gulp.dest(vendor + 'datatables-responsive'));

    gulp.src(['bower_components/flot/*.js'])
        .pipe(gulp.dest(vendor + 'flot'));

    gulp.src(['bower_components/flot.tooltip/js/*.js'])
        .pipe(gulp.dest(vendor + 'flot-tooltip'));

    gulp.src(['bower_components/font-awesome/**/*', '!bower_components/font-awesome/*.json', '!bower_components/font-awesome/.*'])
        .pipe(gulp.dest(vendor + 'font-awesome'));

    gulp.src(['bower_components/jquery/dist/jquery.js', 'bower_components/jquery/dist/jquery.min.js'])
        .pipe(gulp.dest(vendor + 'jquery'));

    gulp.src(['bower_components/metisMenu/dist/*'])
        .pipe(gulp.dest(vendor + 'metisMenu'));

    gulp.src(['bower_components/morrisjs/*.js', 'bower_components/morrisjs/*.css', '!bower_components/morrisjs/Gruntfile.js'])
        .pipe(gulp.dest(vendor + 'morrisjs'));

    gulp.src(['bower_components/raphael/raphael.js', 'bower_components/raphael/raphael.min.js'])
        .pipe(gulp.dest(vendor + 'raphael'));

    gulp.src(['bower_components/bootstrap-datepicker/dist/**/*', '!**/*.map'])
        .pipe(gulp.dest(vendor + 'bootstrap-datepicker'));

    gulp.src(['bower_components/prismjs/**/*.js', 'bower_components/prismjs/**/*.css', '!bower_components/prismjs/gulpfile.js'])
        .pipe(gulp.dest(vendor + 'prismjs'));

    gulp.src(['bower_components/html5shiv/dist/html5shiv.js', 'bower_components/html5shiv/dist/html5shiv.min.js'])
        .pipe(gulp.dest(vendor + 'html5shiv'));

    gulp.src(['bower_components/Respond/dest/respond.src.js', 'bower_components/Respond/dest/respond.min.js'])
        .pipe(gulp.dest(vendor + 'respond'));

    gulp.src(['bower_components/eonasdan-bootstrap-datetimepicker/src/js/*.js'])
        .pipe(gulp.dest(vendor + 'eonasdan-bootstrap-datetimepicker/js'));
    gulp.src(['bower_components/eonasdan-bootstrap-datetimepicker/build/**/*'])
        .pipe(gulp.dest(vendor + 'eonasdan-bootstrap-datetimepicker'));

    gulp.src(['bower_components/moment/moment.js', 'bower_components/moment/min/moment.min.js', 'bower_components/moment/locale/zh-cn.js'])
        .pipe(gulp.dest(vendor + 'moment'));

    gulp.src(['bower_components/chart.js/dist/*.js'])
        .pipe(gulp.dest(vendor + 'chartjs'));

    gulp.src(['bower_components/tinymce/**/*.*'])
        .pipe(gulp.dest(vendor + 'tinymce'));

    gulp.src(['bower_components/clipboard/dist/*.js'])
        .pipe(gulp.dest(vendor + 'clipboard'));

    gulp.src(['bower_components/handlebars/handlebars.js', 'bower_components/handlebars/handlebars.min.js', 'bower_components/handlebars-helpers/src/helpers.js'])
        .pipe(gulp.dest(vendor + 'handlebars'));

    gulp.src(['bower_components/toastr/toastr.js', 'bower_components/toastr/toastr.min.js', 'bower_components/toastr/toastr.css', 'bower_components/toastr/toastr.min.css'])
        .pipe(gulp.dest(vendor + 'toastr'));

    gulp.src(['bower_components/spectrum/spectrum.js', 'bower_components/spectrum/spectrum.css', 'bower_components/spectrum/i18n/jquery.spectrum-zh-cn.js', 'bower_components/spectrum/themes/sp-dark.css'])
        .pipe(gulp.dest(vendor + 'spectrum'));

    gulp.src(['bower_components/blueimp-md5/js/md5.*'])
        .pipe(gulp.dest(vendor + 'md5'));

    gulp.src(['bower_components/codeflask.js/src/*'])
        .pipe(gulp.dest(vendor + 'codeflask'));

    gulp.src(['bower_components/arnapou-jqcron/src/jqCron.js', 'bower_components/arnapou-jqcron/src/jqCron.cn.js', 'bower_components/arnapou-jqcron/src/jqCron.css'])
        .pipe(gulp.dest(vendor + 'jqcron'));

    gulp.src(['bower_components/echarts/dist/echarts.js', 'bower_components/echarts/dist/echarts.min.js', 'bower_components/echarts/dist/echarts.js.map'])
        .pipe(gulp.dest(vendor + 'echarts'));

    gulp.src(['bower_components/jsdiff/diff.js', 'bower_components/jsdiff/diff.min.js']).pipe(gulp.dest(vendor + 'jsdiff'));

    gulp.src(['bower_components/color-thief/dist/color-thief.min.js', 'bower_components/color-thief/src/color-thief.js'])
        .pipe(gulp.dest(vendor + 'color-thief'));

    gulp.src(['bower_components/nprogress/nprogress.*'])
        .pipe(gulp.dest(vendor + 'nprogress'));
});

// Run everything
gulp.task('default', ['minify-css', 'minify-js', 'copy']);

// Configure the browserSync task
gulp.task('browserSync', function () {
    browserSync.init({
        server: {
            baseDir: '../resources/'
        },
    })
})

// Dev task with browserSync
gulp.task('dev', [/*'browserSync', */'sass', 'minify-css', 'js', 'minify-js'], function () {
    gulp.watch('scss/**/*.scss', ['sass']);
    // gulp.watch(dist + 'css/**/*.css', ['minify-css']);
    gulp.watch('js/**/*.js', ['js']);
    // Reloads the browser whenever HTML or JS files change
    // gulp.watch('pages/**/*.html', browserSync.reload);
    // gulp.watch(dist + 'js/**/*.js', browserSync.reload);
});