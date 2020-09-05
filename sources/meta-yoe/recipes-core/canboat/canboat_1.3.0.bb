SUMMARY = "CANBOAT"
SECTION = "base"
LICENSE = "GPLv3"

DEPENDS += "libxslt-native canboat-native"

LIC_FILES_CHKSUM = "file://GPL;md5=05507c6da2404b0e88fe5a152fd12540"

SRC_URI = "git://github.com/canboat/canboat.git;branch=${SRCBRANCH} \
           file://0001-Do-not-use-root-user-group-during-install.patch \
           file://0001-Define-ANALYZEREXEC.patch \
           file://0001-use-php-instead-of-php5.patch \
           file://0001-Avoid-multiple-definitions-of-StringBuffer-sbNew.patch \
          "
SRCBRANCH = "master"

SRCREV = "b8923b45570c21feff89de4eff6007ed5408e1b7"

S = "${WORKDIR}/git"

PREFIX ?= "${root_prefix}"
#PREFIX_class-native = "${prefix}"

EXTRA_OEMAKE_append_class-target = " ANALYZEREXEC=analyzer "

do_compile() {
    oe_runmake
}
do_install() {
   oe_runmake DESTDIR=${D} PREFIX=${root_prefix} EXEC_PREFIX=${exec_prefix} install

}

RDEPENDS_${PN}_append_class-target = " php-cli perl"

BBCLASSEXTEND = "native nativesdk"

