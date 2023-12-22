import { useState, useEffect } from "react";

const Pagination = ({ initData }) => {
    const [results, setResults] = useState(5);
    const [data, setData] = useState(initData);
    const [page, setPage] = useState(0);

    const handleResultsNumber = number => {
        setResults(Number(number));
    };
    const totalPages =number=>{
        setPage(Number(number))
    }

    const handleNextPage = () => {
        setPage(prev => prev + 1);
    };

    const handlePrevPage = () => {
        setPage(prev => (prev > 0 ? prev - 1 : 0));
    };

    useEffect(() => {
        console.log(results, Number(results + page * results));
        setData(initData.slice(page * results, results + page * results));
    }, [initData, results, page]);
    // Generate pagination links based on totalPages
    return {
        handleResultsNumber,
        data,
        handleNextPage,
        handlePrevPage,
        totalPages
    };
};

export default Pagination;
