import NavBarComponent from '@/components/NavBarComponent';
import React from 'react'
import DataTable from 'react-data-table-component'
import { useEffect, useState } from 'react';
import axios from 'axios';

const ProductTables = () => {

  const columns = [
    {
      name: 'Product Name',
      selector: (row) => row.title,
      sortable: true
    },
    {
      name: 'Price',
      selector: (row) => row.price,
    },
    {
      name: 'Category',
      selector: (row) => row.category,
      cell: (row) => row.category.name,
    },
    {
      name: 'Photos',
      selector: (row) => row.images,
      cell: (row) => <img height="84px" width="56px" alt={row.name} src={row.images} />,
    },
    {
      name: 'Action',
      selector: (row) => (
        <div className="d-flex gap-2">
          <button className="btn btn-dark" onClick={() => alert(row.id)}>
            Edit
          </button>
          <button className="btn btn-danger" onClick={() => alert(row.id)}>
            Delete
          </button>
        </div>
      )
    }
  ];

  const [search, setSearch] = useState('');
  const [products, setProducts] = useState([]);
  const [filteredProducts, setFilteredProducts] = useState([]);

  const getProducts = async () => {
    try {
      const response = await axios.get('https://api.escuelajs.co/api/v1/products');
      console.log(response.data); // check if data is being returned
      setProducts(response.data);
      setFilteredProducts(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  

  useEffect(() => {
    getProducts();
  }, []);

//   useEffect(() => {
//     const result = products.filter((product) =>
//       product.name.toLowerCase().includes(search.toLowerCase())
//     );
//     setFilteredProducts(result);
//   }, [search , products]);
useEffect(() => {
    const result = products.filter((product) =>{
        return product.title.toLowerCase().match(search.toLowerCase());
    });
    setFilteredProducts(result);
},[search , products]);
  

  return (
    <>
      <NavBarComponent/>
      <div className='container bg-danger mt-75'>
        <h3>Product collection - table</h3>
        
        <DataTable
          columns={columns}
          data={filteredProducts}
          pagination
          fixedHeader
          fixedHeaderScrollHeight='600px'
          selectableRows
          selectableRowsHighlight
          highlightOnHover
          subHeader
          subHeaderComponent={
            
            <div class="input-group">
  <input  type="text" className="form-control ,w-25" placeholder="Recipient's" aria-label="Recipient's username" aria-describedby="basic-addon2" value={search}
             onChange={(e) => setSearch(e.target.value)}/>
  <div class="input-group-append">
    <button class="btn btn-outline-secondary" type="button">search</button>
    <button class="btn btn-outline-secondary" type="button">type</button>
  </div>
</div>
          }
        >
        </DataTable>
      </div>
    </>
  )
};

export default function Npm() {
  return <ProductTables />;
}
