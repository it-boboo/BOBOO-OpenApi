#!/usr/bin/env python
import codecs
import os

from setuptools import setup, find_packages

description = "Python SDK for Boboo REST And Websocket API (https://www.boboo.com)"

here = os.path.abspath(os.path.dirname(__file__))


def read(*parts):
    with codecs.open(os.path.join(here, *parts), 'r') as fp:
        return fp.read()


setup(
    name="boboo",
    version="1.1",
    author="Boboo",
    author_email="pip@boboo.com",
    description=description,
    long_description=read('README.md'),
    long_description_content_type="text/markdown",
    url="https://github.com/studypy/BOBOO-OpenApi/tree/master/sdk/python",
    packages=find_packages(),
    install_requires=['requests', 'six', 'twisted', 'autobahn', 'pyopenssl', 'service_identity'],
    classifiers=[
        "Programming Language :: Python :: 3",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ],
)