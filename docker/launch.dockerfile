FROM mvn

COPY . /app/${PROJECT}
WORKDIR /app/${PROJECT}

CMD ["mvn"]