FROM nginx
MAINTAINER Joost van Wollingen
LABEL description="a Demo container for Eurostar"
COPY static /usr/share/nginx/html