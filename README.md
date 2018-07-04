# encryption-cli
A helper CLI for [com.github.simbiose:Encryption](https://github.com/simbiose/Encryption) library. This CLI is written in JAVA, due to the limitation that the parent library is in the same language. For those who used this library in an android project and would now like to decrypt the data on a non-android device, this would prove to be very useful.

# Repository Status
[![Build Status](https://travis-ci.com/harshitbudhraja/encryption-cli.svg?token=qtE3zQJXqfvYjFv5yYzb&branch=master)](https://travis-ci.com/harshitbudhraja/encryption-cli)

This continuous build is managed by Travis CI and is repeated at every pushed commit. In case of the pull request, if the build is failed, merging is blocked, by default.

# Initialising a local build

### Mac OS and Linux OS
1. Open a terminal and run `git clone https://github.com/harshitbudhraja/encryption-cli.git` to clone this repository into your local machine.
2. Navigate into that directory using the command `cd encryption-cli/` on the terminal.
3. Make sure that the file `rebuild.sh` has executable permissions. If not, you could do it by executing `sudo chmod +x rebuild.sh` on the terminal. (Enter your machine's password when the terminal prompts you to; this password won't be visible while you're typing it).
4. Go ahead to execute the above script with `sh rebuild.sh`. This will initiate a build process and once completed, you could run the CLI.

# Usage
```
usage: java <classname> [--key <YOUR_KEY>] [--salt <YOUR_SALT>] <args>
There are two arguments which are necessary to be specified:
    --mode	0 (for decryption)
          	1 (for encryption)
    --text	The text to be encrypted or decrypted
The other options available in the CLI are explained below:
    --help	To show this help text
    --salt	The salt can typically be a randomly generated text, but
			it is needed to decrypt the text back.
    --key	This is your secret key that is used for ciphering.
```