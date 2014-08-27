'use strict';
module.exports = function (grunt) {

    // Load grunt tasks automatically
    require('load-grunt-tasks')(grunt);

    // Define the configuration for all the tasks
    grunt.initConfig({

            // Project settings
            hyttebooking: {
                app: 'app'
            },

            // Watches files for changes and runs tasks based on the changed files
            watch: {
                css: {
                    files: '**/*.less',
                    tasks: ['less'],
                    options: {
                        livereload: true
                    }
                },
                js: {
                    files: '<%= hyttebooking.app %>/scripts/**/*.js',
                    options: {
                        livereload: true
                    }
                },
                html: {
                    files: [ '<%= hyttebooking.app %>/*.html', '<%= hyttebooking.app %>/views/*.html' ],
                    options: {
                        livereload: true
                    }
                }
            },

            // The actual grunt server settings
            connect: {
                options: {
                    port: 9000,
                    // Change this to '0.0.0.0' to access the server from outside.
                    hostname: 'localhost',
                    livereload: 35729
                },
                proxies: [
                    {
                        context: '/rest', // the context of the data service
                        host: 'localhost', // wherever the data service is running
                        port: 8080, // the port that the data service is running on
                        https: false
                    }
                ],
                livereload: {
                    options: {
                        open: true,
                        base: [
                            '.tmp',
                            '<%= hyttebooking.app %>'
                        ],
                        middleware: function (connect, options) {
                            var middlewares = [];

                            if (!Array.isArray(options.base)) {
                                options.base = [options.base];
                            }

                            // Setup the proxy
                            middlewares.push(require('grunt-connect-proxy/lib/utils').proxyRequest);

                            // Serve static files
                            options.base.forEach(function (base) {
                                middlewares.push(connect.static(base));
                            });

                            return middlewares;
                        }
                    }
                },
                test: {
                    options: {
                        port: 9001,
                        base: [
                            '.tmp',
                            'test',
                            '<%= hyttebooking.app %>'
                        ]
                    }
                },
                dist: {
                    options: {
                        base: '<%= hyttebooking.dist %>'
                    }
                }
            },

            // Test settings
            karma: {
                unit: {
                    configFile: 'karma.conf.js',
                    singleRun: true
                }
            },
            protractor: {
                options: {
                    keepAlive: true,
                    configFile: "protractor.conf.js"
                },
                run: {
                }
            },
            less: {
                dist: {
                    files: {
                        '<%= hyttebooking.app %>/styles/hyttebooking.css': '<%= hyttebooking.app %>/less/*.less'
                    }
                }
            }


        }
    );


    grunt.registerTask('serve', function (target) {
        if (target === 'dist') {
            return grunt.task.run(['build', 'connect:dist:keepalive']);
        }

        grunt.task.run([
            'less',
            'configureProxies:server',
            'connect:livereload',
            'watch'
        ]);
    });

    grunt.registerTask('server', function () {
        grunt.task.run(['serve']);
    });

    grunt.registerTask('unit', ['karma']);
    grunt.registerTask('e2e', [
        'connect:test',
        'protractor:run'
    ]);


    grunt.registerTask('default', [
        'test',
        'less'
    ]);
}
;
